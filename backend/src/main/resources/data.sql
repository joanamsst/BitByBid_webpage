-- DROP + CREATE rfp_form
DROP TABLE IF EXISTS rfp_form CASCADE;
CREATE TABLE rfp_form
(
    request_id            SERIAL PRIMARY KEY,
    company_name          VARCHAR(255),
    rfp_date              DATE,
    end_date              DATE,
    project_name          VARCHAR(100),
    project_goal          TEXT,
    technical_description TEXT,
    integration_plan      TEXT,
    data_security         TEXT,
    total_price           NUMERIC(12, 2),
    support_and_warranty  TEXT,
    was_accepted BOOLEAN
);

-- DROP + CREATE cronogram (antes chamada de "timeline")
DROP TABLE IF EXISTS cronogram CASCADE;
CREATE TABLE cronogram
(
    id           SERIAL PRIMARY KEY,
    request_id   SERIAL NOT NULL,
    phase_name   VARCHAR(255),
    start_date   DATE,
    end_date     DATE,
    deliverables TEXT,
    CONSTRAINT fk_rfp FOREIGN KEY (request_id) REFERENCES rfp_form (request_id) ON DELETE CASCADE
);

-- DROP + CREATE company_certification
DROP TABLE IF EXISTS company_certification CASCADE;
CREATE TABLE company_certification
(
    id                 SERIAL PRIMARY KEY,
    certification_name VARCHAR(255),
    request_id         SERIAL NOT NULL,
    CONSTRAINT fk_cert_rfp FOREIGN KEY (request_id) REFERENCES rfp_form (request_id) ON DELETE CASCADE
);

-- DROP + CREATE team_member
DROP TABLE IF EXISTS team_member CASCADE;
CREATE TABLE team_member
(
    id             SERIAL PRIMARY KEY,
    member_name    VARCHAR(255),
    role           VARCHAR(255),
    specialization TEXT,
    request_id     BIGINT NOT NULL,
    CONSTRAINT fk_team_rfp FOREIGN KEY (request_id) REFERENCES rfp_form (request_id) ON DELETE CASCADE
);

-- Inserções rfp_form
INSERT INTO rfp_form (company_name, rfp_date, end_date, project_name, project_goal, technical_description,
                      integration_plan, data_security, total_price, support_and_warranty, was_accepted)
VALUES ('TechNova Ltd.', '2025-04-01', '2025-04-30', 'AI Chatbot Development',
        'Create an intelligent chatbot to automate customer service.',
        'Use NLP with Spring Boot backend and PostgreSQL DB.', 'RESTful API integration with CRM.',
        'Data encrypted at rest and in transit. GDPR compliant.', 25000.00,
        '12 months bug fixing and maintenance included.', TRUE),
       ('GreenSolutions Inc.', '2025-04-10', '2025-05-15', 'Smart Irrigation System',
        'Build a smart irrigation platform for urban gardens.', 'IoT sensors with Java backend and mobile dashboard.',
        'MQTT communication + mobile app sync.', 'Encrypted device communication, OAuth 2.0 for users.', 18000.00,
        '6 months free support + on-call assistance.', FALSE);

-- Inserções cronogram (ex-timeline)
INSERT INTO cronogram (request_id, phase_name, start_date, end_date, deliverables)
VALUES (1, 'Design', '2025-04-02', '2025-04-07', 'UX mockups, technical architecture'),
       (1, 'Development', '2025-04-08', '2025-04-20', 'Fully functional chatbot with basic NLP'),
       (1, 'Testing & Delivery', '2025-04-21', '2025-04-29', 'UAT, deployment scripts'),
       (2, 'Prototype', '2025-04-11', '2025-04-18', 'Sensor data capture and local display'),
       (2, 'Pilot Program', '2025-04-19', '2025-04-28', 'Small-scale field test with 5 gardens'),
       (2, 'Deployment', '2025-04-29', '2025-05-10', 'Public launch and training materials');

-- Inserções company_certification
INSERT INTO company_certification (request_id, certification_name)
VALUES (1, 'ISO 27001'),
       (1, 'SOC 2 Type II'),
       (2, 'ISO 9001'),
       (2, 'LEED Green Certification');

-- Inserções team_member
INSERT INTO team_member (request_id, member_name, role, specialization)
VALUES (1, 'Ana Costa', 'Project Manager', 'Agile delivery'),
       (1, 'Luis Silva', 'Backend Developer', 'Spring Boot + PostgreSQL'),
       (2, 'Inês Rocha', 'IoT Engineer', 'Sensor networks'),
       (2, 'Marco Dias', 'Mobile Developer', 'Flutter + Firebase integration');
