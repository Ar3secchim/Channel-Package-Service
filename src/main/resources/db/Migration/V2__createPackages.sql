CREATE TABLE packages (
 id VARCHAR(36) PRIMARY KEY,
 sku_id VARCHAR(36),
 name VARCHAR(36),
 value DECIMAL (10,2),
 FOREIGN KEY (list_channels) REFERENCES channel(id)
 )