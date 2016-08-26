/*
-- Query: SELECT * FROM blog.menu
-- Date: 2016-08-26 18:24
*/
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (1,0,'2016-08-24 10:13:22','2016-08-24 10:13:22','系统设置',NULL,1,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (2,0,'2016-08-24 10:14:40','2016-08-24 10:14:40','编码管理',1,1,'manage/encode');
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (3,0,'2016-08-24 10:15:25','2016-08-24 10:15:25','权限管理',1,2,'manage/authority');
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (4,0,'2016-08-24 10:17:03','2016-08-24 10:17:03','基础设置',NULL,2,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (5,0,'2016-08-24 10:18:17','2016-08-24 10:18:17','菜单管理',1,3,'manage/menu');
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (6,0,'2016-08-24 10:19:37','2016-08-24 10:19:37','商品管理',NULL,3,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (7,0,'2016-08-24 10:21:41','2016-08-24 10:21:41','商品信息',6,1,'manage/product');
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (8,0,'2016-08-24 10:22:03','2016-08-24 10:22:03','商品类型管理',6,2,'manage/productType');
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (9,0,'2016-08-24 10:22:42','2016-08-24 10:22:42','评价管理',NULL,4,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (10,0,'2016-08-24 10:24:55','2016-08-24 10:24:55','新闻管理',NULL,5,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (11,0,'2016-08-24 10:25:05','2016-08-24 10:25:05','订单管理',NULL,6,NULL);
INSERT INTO `menu` (`id`,`version`,`creation`,`last_modified`,`name`,`parent_id`,`seq_num`,`url`) VALUES (12,0,'2016-08-24 10:25:23','2016-08-24 10:25:23','店铺管理',NULL,7,NULL);
