/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
DROP TABLE IF EXISTS players;
CREATE TABLE `players` (
  `player_id` varchar(255) NOT NULL COMMENT 'primary key',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  `player_name` varchar(100) NOT NULL COMMENT 'player name',
  `player_age` int NOT NULL COMMENT 'player age',
  `player_gender` varchar(6) NOT NULL COMMENT 'player gender',
  `team_id` int NOT NULL COMMENT 'foreign team id',
  PRIMARY KEY (`player_id`),
  UNIQUE KEY `team_id` (`team_id`),
  CONSTRAINT `players_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;