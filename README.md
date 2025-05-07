# RFP Manager

An intelligent application built with Java and Spring Boot that allows teams to manage, create, and automatically respond to Requests for Proposals (RFPs) in a fast, structured, and business-oriented way.  
This system combines a robust backend with modern AI integration, streamlining the creation of tailored proposals based on past data and best practices.

---

## Overview

RFP Manager is a complete solution designed for companies that deal with technical and commercial proposals.  
With a solid architecture in Java, a relational database, a simple web interface, and integrated AI, this application enables:

- Creation of professional RFP responses through a structured form  
- Organization of key information: schedules, technical team, attachments, portfolio, certifications  
- Reuse of past knowledge and training of the system using good/bad examples  
- Generation of final PDF documents ready for submission  
- AI-powered generation, improvement, and structuring of proposal content  

The project is fully functional, integrated with a responsive frontend, and ready for deployment on AWS.  
Only user authentication and final AI refinement remain before it’s market-ready.

---

## Artificial Intelligence at the Core

One of the standout features of this application is its use of AI.  
Based on examples of well-written and poorly-written RFPs (stored locally), the system uses few-shot learning with RAG (Retrieval-Augmented Generation) architecture to generate personalized, relevant, and well-structured content.

AI integration is handled via Spring AI (v0.8.1) and supports:

- Retrieval of contextual examples  
- Automatic paragraph generation  
- Context-aware content structuring and suggestions  

---

## Technologies & Tools Used

| Area         | Tools & Frameworks                                                                  |
|--------------|-------------------------------------------------------------------------------------|
| Backend      | Java 17, Spring Boot 3.4.5, Spring Web, Spring Data JPA, JPA/Hibernate, Maven       |
| AI           | Spring AI (v0.8.1), Few-shot Learning, RAG Architecture                             |
| Frontend     | HTML, CSS, JavaScript, Bootstrap, Fetch API                                         |
| Database     | PostgreSQL                                                                          |
| Output       | PDF generation (automatic document creation)                                        |
| Deployment   | Apache Tomcat (embedded), AWS EC2                                                   |

---

## Frontend Integration

The frontend was developed using HTML, CSS, JavaScript, and Bootstrap.  
It allows users to easily fill out a form that feeds into the backend.  
Communication between frontend and backend is handled via Fetch API using JSON.

The UI is:

- Form-based and dynamic  
- Responsive across devices  
- Integrated directly into the Spring Boot application (served via /static)

---

## Deployment & Scalability

- Successfully tested and deployed on AWS EC2  
- PostgreSQL database ready for migration to AWS RDS  
- Embedded Tomcat server enables standalone execution on any Linux environment  
- Modular structure allows the system to scale for different clients or sectors  

---

## Roadmap

- [x] Backend architecture with Spring Boot & PostgreSQL  
- [x] Full integration with HTML/CSS/JS frontend  
- [x] PDF generation of final RFP responses  
- [x] Successful deployment on AWS  
- [x] Initial AI integration with few-shot learning  
- [ ] Implement user authentication with login/session handling  
- [ ] Expand and refine AI training for better precision  
- [ ] Final preparation for production launch with real-world users  

---

## Why This Project?

Responding to RFPs is often a slow, repetitive, and error-prone process.  
This project automates much of that effort, improves response quality and consistency, speeds up delivery, and uses AI as a strategic assistant.

💡 Less time wasted  
💡 Higher consistency  
💡 More winning proposals  

—

Built using Java, JavaScript, HTML, CSS, AI, and real-world problem solving.
