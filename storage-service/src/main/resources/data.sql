INSERT INTO politicians (id, full_name, party, state, office, biography, profile_image_url, start_date)
VALUES
    ('123e4567-e89b-12d3-a456-426614174000', 'John Doe', 'Democratic', 'California', 'Senator', 'Long political history...', 'https://image-url.com/johndoe.jpg', '2018-01-03');

INSERT INTO bills (id, bill_number, title, description, introduced_by, status, introduced_date, bill_url)
VALUES
    ('456e4567-e89b-12d3-a456-426614174111', 'HR1234', 'Healthcare Reform', 'A bill to improve healthcare', '123e4567-e89b-12d3-a456-426614174000', 'Pending', '2023-06-15', 'https://bill-url.com/hr1234');

INSERT INTO voting_records (id, politician_id, bill_id, vote_type, vote_date)
VALUES
    ('789e4567-e89b-12d3-a456-426614174222', '123e4567-e89b-12d3-a456-426614174000', '456e4567-e89b-12d3-a456-426614174111', 'YEA', '2023-06-20');
