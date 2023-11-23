ALTER TABLE package_channel
    DROP FOREIGN KEY package_channel_ibfk_1 ;

ALTER TABLE package_channel
    DROP COLUMN package_id;
