WITH relation AS
(
    SELECT 
    requester_id AS id,
    COUNT(accepter_id) As frnd
    FROM RequestAccepted
    GROUP BY requester_id

    UNION ALL

    SELECT 
    accepter_id AS id,
    COUNT(requester_id) As frnd
    FROM RequestAccepted
    GROUP BY accepter_id
),
friend_count AS
(
    SELECT
    id,
    SUM(frnd) AS total_friends
    FROM relation
    GROUP BY id
)
SELECT
    id,
    total_friends as num
FROM friend_count
WHERE total_friends=(SELECT MAX(total_friends) As maxFrnd FROM friend_count);


