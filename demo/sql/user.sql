CREATE TABLE `user` (
  `uid` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `avatarurl` varchar(255) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;