insert into user_roles
(role_code, name, description, is_admin)
values
    ('SeniorCmpny', 'Senior Company', 'Senior company member at the studio', false),
    ('JuniorCmpny', 'Junior Company', 'Junior company member at the studio', false),
    ('ApprenticeCmpny', 'Apprentice Company', 'Apprentice company member at the studio', false),
    ('PerfCmpny', 'Performance Company', 'Performance company member at the studio', false),
    ('NonCmpnyStudent', 'Other Student',
        'A student who is not a member of any company at the studio', false),
    ('Parent/Guardian', 'Parent / Guardian', 'Parent / Guardian of a Student', false),
    ('Employee', 'Employee', 'Employee (non-administrator) at Dance Studio', false),
    ('Administrator', 'Administrator', 'Application Administrator at Dance Studio', true);
