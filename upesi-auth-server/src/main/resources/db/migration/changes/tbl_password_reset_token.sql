CREATE TABLE tbl_password_reset_token (
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) NOT NULL,
    user_id INT(11) NOT NULL,
    expiry_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    CONSTRAINT fk_tbl_password_reset_token_user_id FOREIGN KEY (user_id) REFERENCES tbl_user_account(id)
);

