<h1>Hotel Booking API</h1>

The Hotel Booking System API is a RESTful web service that allows users to process hotel booking through an API. Users can register, link their rooms in hotel, make and cancel booking, and view their booking history.
<h2>Table of Contents:</h2>
<ul>
    <li>Technologies Used</li>
    <li>Features</li>
    <li>Getting Started</li>
    
</ul>

<h2>Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>MySQL</li>
    <li>Spring Security</li>
    <li>Maven</li>
    <li>Swagger</li>
  </ul>
  
  <h2>Features</h2>
  <ul>
    <li>User registration and authentication with JWT</li>
    <li>Linking list of free rooms in hotel</li>
    <li>Book available room and get list of booking history</li>
    <li>Cancel book room by User</li>
    <li>Update information about the room</li>
    <li>Error handling and validation</li>
    <li>Secure storage of sensitive data (e.g., passwords)</li>
  </ul>
  
  <h2>Getting Started</h2>
  To run the Hotel Booking API locally, follow these steps:
  
  <ol>
    <li>Clone the repository:</li>
    <p><i>https://github.com/ge0rge97/HotelBooking.git</i></p>
    <li>Navigate to the project directory:</li>
    <p><i>cd HotelBooking</i></p>
    <li>Set up the MySQL database and configure the database connection in the application.yaml file.</li>
    </br>
    <li>Build the project using Maven:</li>
    <p><i>mvn clean install</i></p>
    <li>Run the application:</li>
    <p><i>mvn spring-boot:run</i></p>
    <li>The API will be accessible at <b>http://localhost:8080</b></li>
  </ol>
  
  <h2>API Endpoints</h2>
  <p>The API provides the following endpoints:</p>
  <ul>
    <h3>AUTH</h3>
    <li>' POST <b>/api/v1/auth/register</b> ' - User registration</li>
    <li>' POST <b>/api/v1/auth/login</b> ' - User login</li>
    <li>' POST <b>/api/v1/auth/refresh</b> ' - Refresh user tokens</li>
    <h3>USER</h3>
    <li>' GET <b>/api/v1/users/{id}</b> ' - Get User by Id.</li>
    <li>' GET <b>/api/v1/users/{id}/rooms</b> ' - Get All Booked Room by UserId.</li>
    <li>' POST <b>/api/v1/users/{id}/rooms/book/{roomId}</b> ' - Book Room.</li>
    <li>' POST <b>/api/v1/users/{id}/rooms/book/{roomId}/cancel</b> ' - Cancel Book Room.</li>
    <li>' DELETE <b>/api/v1/users/{id}</b> ' - Delete User by Id.</li>
    <h3>ROOMS</h3>
    <li>' GET <b>/api/v1/rooms</b> ' - Get All Hotel Rooms.</li>
    <li>' GET <b>/api/v1/rooms/free</b> ' - Get All Hotel Free Rooms.</li>
    <li>' GET <b>/api/v1/rooms/{id}</b> ' - Get Room by Id.</li>
    <li>' PUT <b>/api/v1/rooms</b> ' - Update Room Information.</li>
    <li>' DELETE <b>/api/v1/rooms/{id}</b> ' - Delete Room by Id.</li>
  </ul>
  <p>For detailed information on each endpoint, refer to the <b><a href="http://localhost:8080/swagger-ui/index.html#/">API documentation</a></b> (based on Swagger).</p>
  
  <h2>Authentication</h2>
  <p>Authentication for API endpoints is performed using JSON Web Tokens (JWT). Users must register and obtain a JWT token to include in the Authorization header of subsequent API requests.</p>
  
  <h2>Error Handling</h2>
  <p>The API handles errors using appropriate HTTP status codes and provides informative error messages in the response body. Common error scenarios include validation errors, authentication failures, and resource not found.</p>

  
