-- 182、编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
-- 例：
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- 结果：
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- 使用连接查询
SELECT p1.`Email` FROM Person AS p1 INNER JOIN
(SELECT id,`Email`,COUNT(Email) AS count FROM Person GROUP BY `Email` HAVING count > 1) AS p2 WHERE p1.id = p2.id ;