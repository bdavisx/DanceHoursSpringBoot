insert into user_roles
(role_code, name, description, is_admin)
values
    ('Student', 'Student', 'Student at the studio', false),
    ('Parent/Guardian', 'Parent / Guardian', 'Parent / Guardian of a Student', false),
    ('Employee', 'Employee', 'Employee (non-administrator) at Dance Studio', false),
    ('Administrator', 'Administrator', 'Application Administrator at Dance Studio', true);
