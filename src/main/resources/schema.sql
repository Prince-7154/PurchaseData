

CREATE TABLE IF NOT EXISTS customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(50) NOT NULL,
    customerAddress VARCHAR(50) NOT NULL,
    customerPhone VARCHAR(50) NOT NULL,
    customerEmail VARCHAR(50) NOT NULL
    );
CREATE TABLE IF NOT EXISTS purchase (

    purchaseId INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT,
    productName VARCHAR(50) NOT NULL ,
    price DOUBLE NOT NULL,
    quantity  INT NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)  ON DELETE CASCADE
    );



