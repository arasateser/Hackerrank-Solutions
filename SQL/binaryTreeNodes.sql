SELECT 
    CASE
        WHEN P IS NULL THEN CONCAT(N, ' Root') /*if N(Node) does not have a P(parent) it is the ROOT*/
        WHEN N IN (SELECT P FROM BST) THEN CONCAT(N, ' Inner') /*If value exist in both columns it means it is a node and parent of another node which makes it a INNER node*/
        ELSE CONCAT(N, ' Leaf') /*logically if its not the root or an inner node it has to be a leaf*/
    END
FROM BST
ORDER BY N

/*N presents nodes and P presents parent of the N(current node) if exist*/