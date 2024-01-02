CREATE TABLE `fashionshop`.`shoes` (
  `id` VARCHAR(25) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `price` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `fashionshop`.`size_shoe`(
	`id` VARCHAR(25) NOT NULL,
    `id_shoe` VARCHAR(25) ,
	`color` VARCHAR(255),
	`size_name` VARCHAR(255),
	`quantity` INT NOT NULL,
	`size_of_shoe` VARCHAR(255),
	PRIMARY KEY (`id`),
	FOREIGN KEY (id_shoe)
      	REFERENCES shoes  (id)
);
CREATE TABLE `fashionshop`.`image_shoe`(
	`id` VARCHAR(25) NOT NULL,
	`id_shoe` VARCHAR(25),
	`url_image` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (id_shoe)
      	REFERENCES shoes  (id)
);
