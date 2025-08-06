package com.example.transformer.service;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.example.transformer.entity.TransformationTemplate;
import com.example.transformer.model.TransformRequest;
import com.example.transformer.output.AvroFormatter;
import com.example.transformer.output.JsonFormatter;
import com.example.transformer.output.XmlFormatter;
import com.example.transformer.parser.InputParser;
import com.example.transformer.parser.InputParserFactory;
import com.example.transformer.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransformService {

    private final TemplateRepository templateRepository;
    private final InputParserFactory parserFactory;
    private final JsonFormatter jsonFormatter;
    private final XmlFormatter xmlFormatter;
    private final AvroFormatter avroFormatter;

    public Object process(TransformRequest request) throws Exception {
        // 1. Fetch template
        TransformationTemplate template = templateRepository.findById(request.getTemplateId())
                .orElseThrow(() -> new IllegalArgumentException("Template not found: " + request.getTemplateId()));

        // 2. Get input parser (json, xml, avro)
        InputParser parser = parserFactory.getParser(request.getInputFormat());

        // 3. Parse payload to map
        Map<String, Object> inputMap = parser.parse(request.getPayload());

        // 4. Apply transformation using JOLT
        Chainr chainr = Chainr.fromSpec(JsonUtils.jsonToList(template.getTransformationSpec()));
        Object transformed = chainr.transform(inputMap);

        // 5. Format output (json, xml, avro)
        return switch (request.getOutputFormat().toLowerCase()) {
            case "json" -> jsonFormatter.format(transformed);
            case "xml" -> xmlFormatter.format(transformed);
            case "avro" -> avroFormatter.format(transformed);
            default -> throw new IllegalArgumentException("Unsupported output format: " + request.getOutputFormat());
        };
    }
}
