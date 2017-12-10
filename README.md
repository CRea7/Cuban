# assignmetn 2 Movie recommender
Name: Conor Rea

# overview
The objective of this assignment was to make a movie recommender. We were to recommend these movies based on ratings that users left.
The data for this was supplied to us and we had to read the files in as an XML file. we also had to be able to create new users, movies
and ratings. We also had to be able to search for each of these.

# Functionality
- Log in feature
- create movies, users and rating
- Cliche command line interface
- search for movies and users
- list all ratings, Movies and users
- Remove a user or a movie
- Remove all movies

# Installation requirements
- Java JRE v1.8
- Guava v18.0
- xStream v1.4.10
- asg.Clichie

# Getting started
all the install reqirements and data files for this programme come with is when you downlaod it.
when you run the programme it will automatically read in the data from the data files.
```
use ?list to get started
LikeMovies> ?list
name     Abbr   ArgNum  Descr
log-in   li     2       use to log in
LikeMovies>
```
- log in as Melody.
```
use ?list to get started
LikeMovies> ?list
Name	Abbr	ArgNum	Descr
log-in	li	2	use to Log in
LikeMovies> li 1 Roberson
Melody Roberson logged in ...
You are logged in as Melody
Admin
LikeMovies/Melody> 
```
# Examples of Programs user interface
- searching for a user using ID
```
LikeMovies/Melody> gu 1
User{1, Melody, Roberson, 53, F, other, 94043, Admin}
LikeMovies/Melody> 
```
- an admins version of ?list
```
Melody Roberson logged in ...
You are logged in as Melody
Admin
LikeMovies/Melody> ?list
Name	Abbr	ArgNum	Descr
get-user	gu	1	serach for a user
get-movie	gm	1	search for a Movie
add-movie	am	3	Create a new movie
add-rating	ar	3	Create a new rating
remove-user	ru	1	removes a user
remove-movie	rm	1	Remove a Movie
remove-all-movies	ram	0	Remove all movies
list-ratings	lr	0	list All Ratings
get-movie-list	gml	0	List all movies
add-user	au	7	Create a new user
list-users	lu	0	lists users
LikeMovies/Melody> 
```
