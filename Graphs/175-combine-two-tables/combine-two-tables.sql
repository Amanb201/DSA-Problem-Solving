# Write your MySQL query statement below
SELECT per.firstName, per.lastName, ad.city, ad.state
FROM Person per LEFT JOIN Address ad
ON per.personId = ad.personId;