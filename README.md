API Functionality:
Accepts a JSON payload and a transformation template ID.
Applies transformation logic as defined in the template.
Returns the transformed output in the expected format.
Template Management UI:
Allows users to create new transformation templates.
Enables editing and deletion of existing templates.
Provides a visual interface to map source fields to target fields.
Validates template structure and transformation rules.
Template Storage:
Templates are stored in a persistent database.
Each template has a unique ID, name, description, and mapping logic.
Error Handling:
Returns appropriate error messages for invalid payloads or template IDs.
Logs transformation failures for debugging.


As a developer,
I want to create an API that accepts an input payload and a transformation template ID,
So that it can apply the transformation logic defined in the template and return the transformed output.
Additionally, I want to provide a UI to create and manage transformation templates, enabling users to map source structures to target structures.


Apache Camel
