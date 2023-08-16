CREATE TABLE tbl_device_metadata (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    device_details VARCHAR(255),
    location VARCHAR(255),
    date_logged_in TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);