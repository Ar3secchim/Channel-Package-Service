CREATE TABLE package_channel (
  id VARCHAR(36) PRIMARY KEY,
  transaction_id VARCHAR(255),
  value DECIMAL(10,2),
  package_id VARCHAR(255),
  FOREIGN KEY (package_id) REFERENCES channels(id)
)
