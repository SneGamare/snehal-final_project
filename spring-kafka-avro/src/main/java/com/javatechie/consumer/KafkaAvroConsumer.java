package com.javatechie.consumer;

import com.javatechie.dto.Employee;
import com.javatechie.entity.EmployeeEntity;
import com.javatechie.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @Autowired
    private EmployeeRepository employeeRepository;

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro message received for key : " + key + " value : " + employee.toString());

        // Convert Avro Employee to Entity and save to database
        EmployeeEntity employeeEntity = new EmployeeEntity(
            employee.getId().toString(),
            employee.getFirstName().toString(),
            employee.getMiddleName().toString(),
            employee.getLastName().toString(),
            employee.getEmailId().toString()
        );
        
        employeeRepository.save(employeeEntity);
        log.info("Employee saved to database with id: " + employeeEntity.getId());
    }
}
