use
task6;

CREATE TABLE `hier`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `plan`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `action`     varchar(255) DEFAULT NULL,
    `name`       varchar(255) DEFAULT NULL,
    `role`       varchar(255) DEFAULT NULL,
    `type`       varchar(255) DEFAULT NULL,
    `user_id`    int(11) DEFAULT NULL,
    `version`    bigint(20) DEFAULT NULL,
    `plan_level` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `FK7va8jmcq9xt51dxk9hmgsm4cn` (`plan_level`),
    CONSTRAINT `FK7va8jmcq9xt51dxk9hmgsm4cn` FOREIGN KEY (`plan_level`) REFERENCES `hier` (`id`)
);

INSERT INTO `hier`
VALUES (1, '001', 'Enterprise Functions > Wells Fargo Technology'),
       (2, '002', 'Enterprise Functions > Legal Department'),
       (3, '003', 'Enterprise Risk Types > Operational Risk > Information Risk Management');

INSERT INTO `plan`
VALUES (1, NULL, NULL, 'Monitoring Plan Owner', 'REMOVE', 1, 1, 1),
       (2, NULL, NULL, 'Monitoring Plan Proxy', 'REMOVE', 1, 1, 2),
       (3, NULL, NULL, 'Monitoring Activity Owner', 'REMOVE', 1, 1, 3);
