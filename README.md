# Report-of-SDA
This software design and architecture report outlines the structural and functional elements of a News Portal System, detailing its main components, user interactions, and system behavior.
# News Portal System Overview: 
The system facilitates interaction between two primary actors—an Admin and a User—by providing functionalities for content management and user engagement.
# 1.Use Case Diagram: 
The use case diagram depicts key interactions between users and the system, including use cases for both the Admin (e.g., managing posts, categories, and comments) and regular users (e.g., browsing, searching, and commenting on news). Relationships between use cases illustrate interactions like includes (where broader actions contain specific sub-actions) and extends (where optional actions, such as Logout, follow main actions like Login).
# 2.System Sequence Diagram: 
The system sequence diagram demonstrates the workflow for post creation, showing the interaction from user request to system validation, database storage, and confirmation response. This structured flow emphasizes data integrity checks and user feedback, ensuring a smooth post creation process.
# 3.Communication Diagram: 
This diagram provides a deeper look at the layered architecture—UI, Controller, Service, and Repository—emphasizing responsibilities within each layer. It illustrates how the Controller receives and delegates user actions to the Service, which handles validation and passes validated data to the Repository for database storage. This sequence highlights the system’s separation of concerns, maintainability, and error handling mechanisms.
# 4.Class Diagram: 
The class diagram defines entities like Category, Subcategory, Posts, Comments, Pages, and Admin, illustrating their roles within the system. Each entity serves distinct functions, from organizing news content to allowing user interaction through comments and static pages.
# Design Principles: 
The communication diagram applies several GRASP principles, including Controller, Information Expert, Low Coupling, High Cohesion, and Creator. These principles promote efficient responsibility assignment, minimize dependencies, and maintain a highly cohesive structure across objects like PostController, PostService, and PostRepository. This design approach ensures a scalable, maintainable, and robust system.
# 5.Package Diagram :
The package diagram for the News Portal System provides an overview of the system's structure by organizing related components into logical layers. This design follows a layered architecture pattern, where each layer serves a specific purpose, promoting separation of concerns, modularity, and ease of maintenance.
The package diagram divides the system into four primary layers, each represented as a package with its own responsibility:
# A. Presentation Layer (UI):
This layer includes components that interact with users. It’s responsible for displaying the interface elements and collecting user input. For the Create Post use case, the PostUI package handles the user’s request to create a new post, such as by providing a form to enter post details.
# B. Business Layer:
The Business Layer, represented by the PostService package in the Create Post use case, handles the core business logic and validation rules of the News Portal System. This layer acts as the central processing unit for the application, receiving validated requests from the Controller Layer and performing all necessary checks and business operations before data is passed to the Data Access Layer.
# C. Service Layer:
The PostService package resides here, which performs the business logic of the system. For the Create Post use case, this layer validates the user’s input, ensuring all required fields (e.g., title, content, category) are provided and meet specified requirements. It is a critical layer for enforcing business rules and conditions.
# D. Data Access Layer (Repository):
The PostRepository package in this layer handles interactions with the database. Once the Service layer completes validation, it delegates the task of persisting the new post to the Repository. This layer ensures data integrity and maintains a consistent connection with the database, allowing posts to be saved, updated, or retrieved as needed.
