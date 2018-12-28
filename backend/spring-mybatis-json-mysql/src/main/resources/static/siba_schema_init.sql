-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema siba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema siba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `siba` DEFAULT CHARACTER SET utf8 ;
USE `siba` ;

-- -----------------------------------------------------
-- Table `siba`.`food_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`food_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`food` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `food_type_id` INT(11) NOT NULL,
  `calorie` FLOAT NULL DEFAULT 0,
  `carbohydrate` FLOAT NULL DEFAULT 0,
  `protein` FLOAT NULL DEFAULT 0,
  `fat` FLOAT NULL DEFAULT 0,
  `natrium` FLOAT NULL DEFAULT 0,
  `hash_tag` VARCHAR(45) NULL DEFAULT NULL,
  `small_image_location` VARCHAR(500) NULL DEFAULT NULL,
  `big_image_location` VARCHAR(500) NULL DEFAULT NULL,
  `ingredients` VARCHAR(1000) NULL DEFAULT NULL,
  `like_it` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `food_type_id_idx` (`food_type_id` ASC),
  CONSTRAINT `food_type_id`
    FOREIGN KEY (`food_type_id`)
    REFERENCES `siba`.`food_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 754
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`comments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `food_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `comments` VARCHAR(1000) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `reg_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `food_comments_id_idx` (`food_id` ASC),
  CONSTRAINT `food_comments_id`
    FOREIGN KEY (`food_id`)
    REFERENCES `siba`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`food_ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`food_ingredients` (
  `food_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  INDEX `food_ingredients_id_idx` (`food_id` ASC),
  CONSTRAINT `food_ingredients_id`
    FOREIGN KEY (`food_id`)
    REFERENCES `siba`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`food_recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`food_recipe` (
  `food_id` INT(11) NOT NULL,
  `recipe_desc` VARCHAR(1000) NOT NULL,
  `image_location` VARCHAR(500) NULL DEFAULT NULL,
  INDEX `food_id_idx` (`food_id` ASC),
  CONSTRAINT `food_id`
    FOREIGN KEY (`food_id`)
    REFERENCES `siba`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`ingredient_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`ingredient_category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`ingredient_sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`ingredient_sub_category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `ingredient_category_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingredient_sub_category_ingredient_category1_idx` (`ingredient_category_id` ASC),
  CONSTRAINT `fk_ingredient_sub_category_ingredient_category1`
    FOREIGN KEY (`ingredient_category_id`)
    REFERENCES `siba`.`ingredient_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`ingredient_sub_sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`ingredient_sub_sub_category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `file_name` VARCHAR(200) NOT NULL,
  `ingredient_sub_category_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingredient_sub_sub_category_ingredient_sub_category1_idx` (`ingredient_sub_category_id` ASC),
  CONSTRAINT `fk_ingredient_sub_sub_category_ingredient_sub_category1`
    FOREIGN KEY (`ingredient_sub_category_id`)
    REFERENCES `siba`.`ingredient_sub_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`my_favorates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`my_favorates` (
  `food_id` INT(11) NOT NULL,
  INDEX `fk_my_favorates_food1_idx` (`food_id` ASC),
  CONSTRAINT `fk_my_favorates_food1`
    FOREIGN KEY (`food_id`)
    REFERENCES `siba`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`my_notepad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`my_notepad` (
  `ingredient_name` VARCHAR(150) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `siba`.`my_refrigerator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `siba`.`my_refrigerator` (
  `ingredient_sub_sub_category_id` INT(11) NOT NULL,
  INDEX `fk_my_refrigerator_ingredient_sub_sub_category1_idx` (`ingredient_sub_sub_category_id` ASC),
  CONSTRAINT `fk_my_refrigerator_ingredient_sub_sub_category1`
    FOREIGN KEY (`ingredient_sub_sub_category_id`)
    REFERENCES `siba`.`ingredient_sub_sub_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
