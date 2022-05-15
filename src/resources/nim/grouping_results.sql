SELECT COUNT(*) FROM users u ;

INSERT INTO users (name, created)
VALUES ("Valdis", CURRENT_TIMESTAMP);

INSERT INTO users (name, created)
VALUES ("Alice", CURRENT_TIMESTAMP);

SELECT COUNT(*) FROM users u 
WHERE name = "Valdis";

SELECT id FROM users u 
WHERE name = "Valdis"
LIMIT 1;

SELECT id FROM users u 
WHERE name = "Alice";

--we do not need to display the column we group by
SELECT u.name, u.id , COUNT(winner) wins 
FROM results r 
JOIN users u 
ON u.id = r.winner
GROUP BY winner
ORDER BY wins DESC;

--we do not need to display the column we group by
CREATE VIEW winners 
AS
SELECT u.name, u.id , COUNT(winner) wins
FROM results r 
JOIN users u 
ON u.id = r.winner
GROUP BY winner
ORDER BY wins DESC;

CREATE VIEW losers
AS
SELECT u.name, u.id , COUNT(loser) losses
FROM results r 
JOIN users u 
ON u.id = r.loser
GROUP BY loser
ORDER BY losses DESC;

-- https://www.sqlitetutorial.net/sqlite-full-outer-join/
-- https://stackoverflow.com/questions/5706437/whats-the-difference-between-inner-join-left-join-right-join-and-full-join

SELECT w.id,w.name,w.wins, l.losses FROM winners w 
LEFT JOIN losers l 
ON w.id = l.id
UNION ALL 
SELECT w2.id,w2.name,w2.wins, l2.losses FROM losers l2 
LEFT JOIN winners w2 
ON l2.id = w2.id;