CREATE TABLE tbl_user_location (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    country VARCHAR(255) NOT NULL,
    enabled TINYINT(1) DEFAULT 0,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    CONSTRAINT fk_tbl_user_location_user_id FOREIGN KEY (user_id) REFERENCES tbl_user_account(id)
);

