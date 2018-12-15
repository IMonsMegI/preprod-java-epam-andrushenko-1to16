-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema InternetTVShop
-- -----------------------------------------------------
drop database if exists internettvshop;
-- -----------------------------------------------------
-- Schema InternetTVShop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internettvshop` DEFAULT CHARACTER SET latin1 ;
USE `internettvshop` ;


-- -----------------------------------------------------
-- Table `InternetTVShop`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`user_role` (
  `id_role` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into user_role values(0,'admin');
insert into user_role values(1,'user');



-- -----------------------------------------------------
-- Table `InternetTVShop`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`users` (
  `id_user` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `image` VARCHAR(100) NOT NULL DEFAULT 'default-user-avatar-30-30.jpg',
  `id_role` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `id_role`
	FOREIGN KEY (`id_role`)
		REFERENCES `internettvshop`.`user_role` (`id_role`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into users values(0,'Michael','Andr','MonsMeg','micha@gmail.com','qwerty','default-user-avatar-30-30.jpg',0);
insert into users values(default,'Artem','Artem','user666','artem@gmail.com','asdfgh','default-user-avatar-30-30.jpg',1);


-- -----------------------------------------------------
-- Table `InternetTVShop`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`product_category` (
  `id_category` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into product_category values(0,'Smart TV');
insert into product_category values(1,'TV 4k');


-- -----------------------------------------------------
-- Table `InternetTVShop`.`product_manufacture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`product_manufacture` (
  `id_manufacture` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_manufacture`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into product_manufacture values(0,'Samsung');
insert into product_manufacture values(1,'LG');
insert into product_manufacture values(2,'Sony');


-- -----------------------------------------------------
-- Table `InternetTVShop`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`products` (
  `id_product` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(100) NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  `image` VARCHAR(100) NOT NULL,
  `id_manufacture` INT(10) UNSIGNED NOT NULL,
  `id_category` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_product`),
CONSTRAINT `id_category`
	FOREIGN KEY (`id_category`)
		REFERENCES `internettvshop`.`product_category` (`id_category`)
        ON DELETE CASCADE
		ON UPDATE CASCADE,
CONSTRAINT `id_manufacture`
	FOREIGN KEY (`id_manufacture`)
		REFERENCES `internettvshop`.`product_manufacture` (`id_manufacture`)
		ON DELETE CASCADE
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into products values(0,'Samsung LED Super S800',30000,'tv1.jpg',0,1);
insert into products values(default,'LG Full Vision',45000,'tv2.jpg',1,1);
insert into products values(default,'Sony High 240',35000,'tv3.jpg',2,0);
insert into products values(default,'Samsung Ultra 120',30000,'tv4.jpg',0,1);
insert into products values(default,'Samsung pixel 200',28000,'tv5.jpg',0,0);
insert into products values(default,'Sony LED Super S800',42100,'tv6.jpg',2,0);
insert into products values(default,'Samsung Smart 300',38000,'tv7.jpg',0,0);
insert into products values(default,'LG Super Plazma',37500,'tv8.jpg',1,0);
insert into products values(default,'Sony 43 LED FHD Smart Black',43500,'tv9.jpg',2,1);
insert into products values(default,'LG 49 LED UHD Smart Black',47000,'tv10.jpg',1,0);
insert into products values(default,'Sony LED HD White',55000,'tv11.jpg',2,1);
insert into products values(default,'Samsung 55 LED FHD Smart',29000,'tv12.jpg',0,1);
insert into products values(default,'LG LED HD Black',43000,'tv13.jpg',1,0);
insert into products values(default,'Samsung 55 QLED UHD Smart Curved Silver',37500,'tv14.jpg',0,0);
insert into products values(default,'Sony LED UHD Smart Black',49400,'tv15.jpg',2,0);
insert into products values(default,'LG 49 LED FHD Smart Black',37800,'tv16.jpg',1,1);


-- -----------------------------------------------------
-- Table `InternetTVShop`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`order_status` (
  `id_order_status` INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_order_status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into order_status values(0,'accepted');
insert into order_status values(1,'confirmed');
insert into order_status values(2,'process');
insert into order_status values(3,'exiled');
insert into order_status values(4,'closed');
insert into order_status values(5,'canceled');


-- -----------------------------------------------------
-- Table `InternetTVShop`.`order_product_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`order_product_info` (
  `id_order_product` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_order` INT(10) UNSIGNED NOT NULL,
  `id_product` INT(10) UNSIGNED NOT NULL,
  `count` INT(10) UNSIGNED NOT NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_order_product`),
  CONSTRAINT `id_order`
		FOREIGN KEY (`id_order`)
			REFERENCES `internettvshop`.`orders` (`id_order`)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
        CONSTRAINT `id_product`
			FOREIGN KEY  (`id_product`) REFERENCES `internettvshop`.`products` (`id_product`)
			ON DELETE CASCADE
			ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into order_product_info values(0,1,1,2,35500);
insert into order_product_info values(default,1,2,1,40000);
insert into order_product_info values(default,5,1,3,37800);


-- -----------------------------------------------------
-- Table `InternetTVShop`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internettvshop`.`orders`(
  `id_order` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_status` INT(10) UNSIGNED NOT NULL,
  `descriptionOfStatus` VARCHAR(100),
  `date` TIMESTAMP NOT NULL,
  `id_user` INT(10) UNSIGNED  NOT NULL,
  PRIMARY KEY (`id_order`),
  CONSTRAINT `id_status`
	FOREIGN KEY (`id_status`)
		REFERENCES `internettvshop`.`order_status` (`id_order_status`)
        ON DELETE CASCADE
		ON UPDATE CASCADE,
	CONSTRAINT `id_user`
		FOREIGN KEY (`id_user`)
			REFERENCES `internettvshop`.`users` (`id_user`)
			ON DELETE CASCADE
			ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


insert into orders values(0,2,'In process around 2 days','2018-09-028 16:48:00',2);
insert into orders values(default,3,'Exiled 1 day ago','2018-10-04 02:18:00',4);
insert into orders values(default,0,'','2018-10-02 12:38:00',1);




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
