CREATE DATABASE travelwithme;
\c travelwithme;

CREATE TABLE places(
 id serial PRIMARY KEY,
 destinantion varchar,
 location varchar,
 imageUrl varchar,
 description varchar
 );
CREATE TABLE reviews(
id serial PRIMARY KEY,
name varchar,
rating int,
description varchar
);

CREATE DATABASE travelwithme_test WITH TEMPLATE travelwithme;