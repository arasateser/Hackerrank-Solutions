SELECT s.hacker_id, h.name
FROM Submissions s
JOIN Challenges c ON c.challenge_id = s.challenge_id
JOIN Difficulty d ON d.difficulty_level = c.difficulty_level
JOIN Hackers h ON h.hacker_id = s.hacker_id
WHERE d.score = s.score
GROUP BY s.hacker_id, h.name
    HAVING COUNT(s.hacker_id)>1
ORDER BY COUNT(s.hacker_id) desc, s.hacker_id

/*DO NOT JOIN hacer_id using hackers and challenges id's. challanges table is for CREATING challanges which needs to stay static. use submissions table instead like I did

WE DO NOT need to check if hackers got full score on their test to order them because hackers on this query already got full scores on their tests*/