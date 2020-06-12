CREATE DATABASE pokemons;

CREATE TABLE `pokemons`.`bitacora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `request` VARCHAR(150) NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `metodo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
