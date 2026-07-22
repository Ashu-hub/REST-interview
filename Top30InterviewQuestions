
---

# 1. What is REST?

**Answer:**

REST (Representational State Transfer) is an architectural style for designing web services. It was introduced by **Roy Fielding** in his PhD dissertation. REST uses standard HTTP methods to perform CRUD operations on resources.

**Example**

```http
GET /users/101
```

Here, **User** is the resource.

---

# 2. What are REST Constraints?

REST has six architectural constraints:

1. Client-Server
2. Stateless
3. Cacheable
4. Uniform Interface
5. Layered System
6. Code on Demand (Optional)

A service must satisfy these constraints to be considered RESTful.

---

# 3. What is Statelessness?

Every request must contain all the information needed to process it.

The server **does not store client session information**.

**Example**

```http
GET /users/101
Authorization: Bearer <JWT>
```

The JWT is sent with every request.

### Advantages

- Easy Horizontal Scaling
- Better Fault Tolerance
- No Session Replication
- Suitable for Microservices

---

# 4. What is a Resource?

A resource is anything exposed through the API.

Examples:

```text
/users
/orders
/products
/payments
```

Resources are identified using URIs.

---

# 5. REST vs SOAP

| REST | SOAP |
|------|------|
| Architectural Style | Protocol |
| JSON/XML | XML Only |
| Lightweight | Heavy |
| Faster | Slower |
| Uses HTTP | Supports Multiple Protocols |
| Stateless | Can be Stateful |

---

# 6. Difference Between PUT and PATCH

## PUT

- Replaces the entire resource.
- Idempotent.

```http
PUT /users/101

{
  "name":"John",
  "age":30
}
```

---

## PATCH

- Updates only selected fields.

```http
PATCH /users/101

{
  "age":31
}
```

---

# 7. Difference Between POST and PUT

| POST | PUT |
|------|-----|
| Create Resource | Create/Update Resource |
| Server Generates ID | Client Knows Resource ID |
| Not Idempotent | Idempotent |

---

# 8. What is Idempotency?

Calling the same API multiple times produces the same result.

### Idempotent Methods

- GET
- PUT
- DELETE
- HEAD
- OPTIONS

**POST is generally NOT idempotent.**

---

# 9. Which HTTP Methods are Safe?

Safe methods do not modify data.

- GET
- HEAD
- OPTIONS

---

# 10. Explain HTTP Methods

| Method | Purpose |
|---------|---------|
| GET | Read |
| POST | Create |
| PUT | Replace |
| PATCH | Partial Update |
| DELETE | Delete |
| HEAD | Headers Only |
| OPTIONS | Supported Methods |

---

# 11. What is HATEOAS?

**Hypermedia As The Engine Of Application State**

The server returns hyperlinks indicating the next possible actions.

Example:

```json
{
  "id":101,
  "_links":{
      "self":"/users/101",
      "orders":"/users/101/orders",
      "update":"/users/101"
  }
}
```

This is **Level 3** of the Richardson Maturity Model.

---

# 12. What is Richardson Maturity Model?

| Level | Description |
|--------|-------------|
| Level 0 | Single Endpoint (RPC Style) |
| Level 1 | Resources |
| Level 2 | Resources + HTTP Methods + Status Codes |
| Level 3 | HATEOAS |

**Most enterprise APIs implement Level 2.**

---

# 13. URI vs URL vs URN

## URI

General identifier.

## URL

Location of the resource.

Example:

```text
https://example.com/users/1
```

## URN

Unique resource name.

Example:

```text
urn:isbn:123456
```

---

# 14. Important HTTP Status Codes

## Success

| Code | Meaning |
|------|---------|
| 200 | OK |
| 201 | Created |
| 202 | Accepted |
| 204 | No Content |

## Redirection

| Code | Meaning |
|------|---------|
| 301 | Moved Permanently |
| 304 | Not Modified |

## Client Errors

| Code | Meaning |
|------|---------|
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 405 | Method Not Allowed |
| 409 | Conflict |
| 415 | Unsupported Media Type |
| 429 | Too Many Requests |

## Server Errors

| Code | Meaning |
|------|---------|
| 500 | Internal Server Error |
| 502 | Bad Gateway |
| 503 | Service Unavailable |
| 504 | Gateway Timeout |

---

# 15. Difference Between 401 and 403

**401 Unauthorized**

Authentication is missing or invalid.

**403 Forbidden**

User is authenticated but does not have permission.

---

# 16. Difference Between 400 and 404

**400**

Invalid client request.

**404**

Requested resource does not exist.

---

# 17. Difference Between 200 and 204

**200 OK**

Returns response body.

**204 No Content**

Operation successful but no response body.

Commonly returned after DELETE.

---

# 18. What is Content Negotiation?

The client tells the server the desired response format.

Example:

```http
Accept: application/json
```

The server returns JSON, XML, etc., based on the header.

---

# 19. Common HTTP Headers

- Authorization
- Content-Type
- Accept
- Cache-Control
- ETag
- If-None-Match
- Correlation-ID

---

# 20. What is ETag?

Entity Tag identifies the version of a resource.

Used for:

- HTTP Caching
- Optimistic Locking

---

# 21. What is Optimistic Locking in REST?

The client sends the current version.

```http
If-Match: "v3"
```

If the resource has changed:

```http
412 Precondition Failed
```

Prevents lost updates.

---

# 22. API Versioning Strategies

## URI Versioning

```text
/v1/users
```

## Header Versioning

```http
Accept-Version: v2
```

## Media Type Versioning

```http
application/vnd.company.v2+json
```

URI versioning is the most commonly used.

---

# 23. What is Pagination?

Instead of returning millions of records:

```http
GET /users?page=2&size=20
```

Spring Boot provides:

```java
Pageable pageable
```

---

# 24. Offset vs Cursor Pagination

## Offset Pagination

```text
?page=5&size=20
```

Pros

- Easy

Cons

- Slow on large datasets

---

## Cursor Pagination

```text
?cursor=abc123
```

Pros

- Faster
- Better for large datasets

---

# 25. How Do You Secure REST APIs?

- JWT Authentication
- OAuth2
- HTTPS
- API Gateway
- Role-Based Access Control (RBAC)
- Rate Limiting
- Input Validation
- CORS
- CSRF Protection (where applicable)

---

# 26. What is JWT?

JSON Web Token.

Consists of:

- Header
- Payload
- Signature

Sent as:

```http
Authorization: Bearer <token>
```

---

# 27. Authentication vs Authorization

| Authentication | Authorization |
|---------------|---------------|
| Who are you? | What can you access? |
| Verifies Identity | Verifies Permissions |

---

# 28. How Do You Make REST APIs Idempotent?

- Use PUT instead of POST where appropriate.
- Use Idempotency-Key for POST requests.
- Maintain unique request IDs.
- Prevent duplicate processing.

---

# 29. REST API Best Practices

- Use nouns instead of verbs.
- Use proper HTTP methods.
- Return appropriate HTTP status codes.
- Keep APIs stateless.
- Validate request payloads.
- Use pagination for large datasets.
- Version APIs.
- Secure using OAuth2/JWT.
- Return meaningful error messages.
- Document APIs using OpenAPI/Swagger.

---

# 30. Interview Answer: REST Best Practices in Your Project

> In my Spring Boot microservices, I design resource-oriented APIs using nouns, proper HTTP methods, and appropriate HTTP status codes. The services are stateless and secured using JWT/OAuth2 with an API Gateway. I implement Bean Validation for request validation, centralized exception handling using `@ControllerAdvice`, pagination for large datasets, API versioning, correlation IDs for distributed tracing, OpenAPI/Swagger documentation, and meaningful error responses. For resilience, I use retries, timeouts, and circuit breakers, and for concurrency control I use optimistic locking where applicable.

---

# Top 10 Must-Prepare REST Questions

1. What is REST?
2. REST Constraints
3. Statelessness
4. PUT vs PATCH
5. POST vs PUT
6. Idempotency
7. HTTP Status Codes
8. Richardson Maturity Model
9. JWT Authentication Flow
10. REST API Best Practices

---

# Quick Revision Cheat Sheet

| Topic | Key Point |
|--------|-----------|
| REST | Architectural Style |
| Resource | URI |
| Stateless | No Session on Server |
| GET | Read |
| POST | Create |
| PUT | Replace Entire Resource |
| PATCH | Partial Update |
| DELETE | Delete Resource |
| Safe Methods | GET, HEAD, OPTIONS |
| Idempotent | GET, PUT, DELETE |
| Authentication | Verify Identity |
| Authorization | Verify Permissions |
| JWT | Header + Payload + Signature |
| Best Status Codes | 200, 201, 204, 400, 401, 403, 404, 409, 500 |
| Pagination | Pageable |
| API Versioning | `/v1/users` |
| Most Used RMM Level | Level 2 |
| HATEOAS | Level 3 |
