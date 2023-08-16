CREATE TABLE tbl_role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    privilege_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_tbl_role_user_id FOREIGN KEY (user_id) REFERENCES tbl_user_account(id),
    CONSTRAINT fk_tbl_role_privilege FOREIGN KEY (privilege_id) REFERENCES tbl_privilege(id)
);
