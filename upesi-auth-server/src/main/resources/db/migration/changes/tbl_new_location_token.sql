CREATE TABLE tbl_new_location_token (
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) NOT NULL,
    user_location_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    CONSTRAINT fk_tbl_new_location_token_user_location FOREIGN KEY (user_location_id) REFERENCES tbl_user_location(id)
);

