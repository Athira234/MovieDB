package com.entlogics.moviedb.admin.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.entlogics.moviedb.admin.entities.Company;
import com.entlogics.moviedb.admin.entities.Genre;
import com.entlogics.moviedb.admin.entities.Person;
import com.entlogics.moviedb.admin.repository.IAdminRepository;
import com.entlogics.moviedb.movie.entities.Movie;
import com.entlogics.moviedb.user.entities.User;

@Repository
public class AdminRepository implements IAdminRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("MDB");
	LocalDate localDate = LocalDate.now();

	// find all companies
	public List<Company> findAllCompanies() {
		System.out.println("Inside AdminRepository findAllCompanies()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//get list of companies from database
		List<Company> companies = entityManager.createNativeQuery("select * from dt_company", Company.class)
				.getResultList();
		System.out.println("printing list of companies " + companies.size() + "\n" + companies);
		entityManager.getTransaction().commit();
		entityManager.close();
		return companies;
	}

	// find a Company details
	public Company findCompany(int companyId) {
		System.out.println("Inside AdminRepository findCompany()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//find company by id
		Company company = entityManager.find(Company.class, companyId);
		System.out.println("company details :" + company);
		entityManager.getTransaction().commit();
		entityManager.close();
		return company;
	}

	// add new company
	public void addCompany(Company company) {

		System.out.println("Inside AdminRepository addCompany()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//save company object 
		entityManager.persist(company);
		entityManager.getTransaction().commit();
		System.out.println("Company details :" + company);
		entityManager.close();
	}

	// updating a company
	public void updateCompany(Company company) {

		System.out.println("Inside AdminRepository updateCompany()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//update company
		entityManager.merge(company);
		System.out.println("Company details :" + company);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// deleting a company
	public void deleteCompany(int companyId) {

		System.out.println("Inside AdminRepository deleteCompany()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//find the company in db with companyId
		Company company = entityManager.find(Company.class, companyId);
		//remove company from db
		entityManager.remove(company);
		System.out.println("deleted");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// add new Movie
	public void addMovie(Movie movie) {
		System.out.println("Inside AdminRepository addMovie()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		// movie object will passed when implementing controller
		entityManager.persist(movie);
		System.out.println("Movie details :" + movie);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	// updating a Movie
	public void updateMovie(Movie movie) {
		System.out.println("Inside AdminRepository updateMovie()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(movie);
		System.out.println("Movie details :" + movie);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// deleting a Movie
	public void deleteMovie(int movieId) {
		System.out.println("Inside AdminRepository deleteMovie()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		//find movie with id movieId
		Movie movie = entityManager.find(Movie.class, movieId);
		//delete movie from db
		entityManager.remove(movie);
		System.out.println("deleted");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// find list of Persons
	public List<Person> findAllPersons() {
		System.out.println("Inside AdminRepository findAllPersons()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Person> persons = entityManager.createNativeQuery("select * from dt_person", Person.class).getResultList();
		System.out.println("printing list of persons " + persons.size() + "\n" + persons);
		entityManager.getTransaction().commit();
		entityManager.close();
		return persons;
	}

	// find a Person details
	public Person findPerson(int personId) {
		System.out.println("Inside AdminRepository findPerson()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Person person = entityManager.find(Person.class, personId);
		System.out.println("Person details :" + person);
		entityManager.getTransaction().commit();
		entityManager.close();
		return person;
	}

	// add new Person
	public void addPerson(Person person) {
		System.out.println("Inside AdminRepository addPerson()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		System.out.println("Person details :" + person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// updating a Person
	public void updatePerson(Person person) {
		System.out.println("Inside AdminRepository updatePerson()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(person);
		System.out.println("person details :" + person);
		entityManager.getTransaction().commit();
	}

	// deleting a Person
	public void deletePerson(int personId) {
		System.out.println("Inside AdminRepository deletePerson()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Person person = entityManager.find(Person.class, personId);
		entityManager.remove(person);
		System.out.println("deleted");
		entityManager.getTransaction().commit();

	}

	// find list of Genre
	public List<Genre> findAllGenre() {
		System.out.println("Inside AdminRepository findAllGenre()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Genre> genre = entityManager.createNativeQuery("select * from dt_genre", Genre.class).getResultList();
		System.out.println("printing list of genre " + genre.size() + "\n" + genre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}

	// add new Genre
	public void addGenre(Genre genre) {
		System.out.println("Inside AdminRepository addGenre()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(genre);
		System.out.println("Genre details :" + genre);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	// updating a genre
	public void updateGenre(Genre genre) {
		System.out.println("Inside AdminRepository updateGenre()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(genre);
		System.out.println("Genre details :" + genre);
		entityManager.getTransaction().commit();

		entityManager.close();
	}

	// deleting a Genre
	public void deleteGenre(int genreId) {
		System.out.println("Inside AdminRepository deleteGenre()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, genreId);
		entityManager.remove(genre);
		System.out.println("deleted");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Genre findGenre(int genreId) {
		System.out.println("Inside AdminRepository findGenre()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, genreId);
		System.out.println("genre details :" + genre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}

	@Override
	public List<User> findAllUsers() {
		System.out.println("Inside AdminRepository findAllUsers()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<User> users = entityManager.createNativeQuery("select * from dt_user", User.class).getResultList();
		System.out.println("printing list of users " + users.size() + "\n" + users);
		entityManager.getTransaction().commit();
		entityManager.close();
		return users;
	}

	@Override
	public void deleteUser(int userId) {
		System.out.println("Inside AdminRepository deleteUser()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
		System.out.println("deleted");
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void addUser(User user) {
		System.out.println("Inside AdminRepository addUser()");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		user.setCreatedBy("ADMIN");
		user.setCreatedDate(localDate);
		user.setLastPasswordChange(localDate);
		user.setProfileImage(null);
		entityManager.persist(user);
		System.out.println("User details :" + user);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void updateUser(User user) {
		System.out.println("Inside AdminRepository updateUser()");
		EntityManager entityManager = factory.createEntityManager();
		try {

			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		AdminRepository repo = new AdminRepository();
		// repo.findAllMovies();
		// repo.findMovie(8);
		// repo.findAllPersons();
		// repo.deleteMovie(8);
		// repo.findPerson(1);
		// repo.findAllGenre();
		// repo.deleteGenre(9);
		// repo.findAllCompanies();
		// repo.findCompany(1);
		// repo.findGenre(1);
		repo.findAllUsers();

	}

}
