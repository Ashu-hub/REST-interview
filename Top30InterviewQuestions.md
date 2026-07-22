
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

1. Client-Server : The client and server are separated and have distinct responsibilities.
2. Stateless : Stateless means the server never remembers previous requests. Every request is completely independent.
3. Cacheable : Responses should indicate whether they can be cached. The client can reuse cached responses until they expire.
4. Uniform Interface : It standardizes communication between clients and servers.
   It has 4 principle:
   a) Resource Identification: Every resource should have a unique URI.
   b) Resource Representation: The client interacts with a representation of the resource, usually JSON or XML.
   c) Self-descriptive Messages : Each request and response should contain enough information to understand it.
   d) HATEOAS : The server tells the client what actions can be performed next.
6. Layered System: The client does not know whether it is communicating directly with the server or through intermediate layers.
7. Code on Demand (Optional): The server can send executable code to the client.(REST API do **NOT** use this constraint.

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
The Richardson Maturity Model (RMM) is a framework proposed by Leonard Richardson to evaluate how closely a web API follows REST architectural principles. It defines four maturity levels (0–3), where each higher level builds on the previous one.
| Level                              | Characteristics                                                                                                                                             | Example                                                          |
| ---------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| **Level 0 – The Swamp of POX**     | Single endpoint, usually one HTTP method (typically POST). HTTP is used only as a transport protocol.                                                       | `POST /api` with `"action":"createUser"`                         |
| **Level 1 – Resources**            | Introduces resources with separate URIs, but still often uses a single HTTP method.                                                                         | `POST /users`, `POST /orders`                                    |
| **Level 2 – HTTP Verbs**           | Uses HTTP methods correctly (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`) along with appropriate status codes. This is the level most modern REST APIs achieve. | `GET /users/123`, `PUT /users/123`, `DELETE /users/123`          |
| **Level 3 – Hypermedia (HATEOAS)** | Responses include hyperlinks that tell clients what actions are available next, making the API self-discoverable.                                           | Response contains links such as `"edit"`, `"delete"`, `"orders"` |


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

| Code    | Meaning    | Description                                                                                                          |
| ------- | ---------- | -------------------------------------------------------------------------------------------------------------------- |
| **200** | OK         | The request was successful, and the response contains the requested data.                                            |
| **201** | Created    | A new resource was successfully created (typically returned after a POST request).                                   |
| **202** | Accepted   | The request has been accepted for processing, but processing is not yet complete (used for asynchronous operations). |
| **204** | No Content | The request was successful, but there is no response body (commonly returned after DELETE or successful PUT).        |


## Redirection

| Code    | Meaning           | Description                                                                                       |
| ------- | ----------------- | ------------------------------------------------------------------------------------------------- |
| **301** | Moved Permanently | The requested resource has permanently moved to a new URL. Clients should update their bookmarks. |
| **304** | Not Modified      | The resource has not changed since the last request. The client should use its cached copy.       |


## Client Errors

| Code    | Meaning                | Description                                                                                                           |
| ------- | ---------------------- | --------------------------------------------------------------------------------------------------------------------- |
| **400** | Bad Request            | The request is invalid due to malformed syntax, validation errors, or missing required fields.                        |
| **401** | Unauthorized           | Authentication is required or the provided credentials/token are invalid or expired.                                  |
| **403** | Forbidden              | The user is authenticated but does not have permission to access the requested resource.                              |
| **404** | Not Found              | The requested resource does not exist.                                                                                |
| **405** | Method Not Allowed     | The requested HTTP method (e.g., POST, DELETE) is not supported for the requested resource.                           |
| **409** | Conflict               | The request conflicts with the current state of the resource (e.g., duplicate email, version conflict).               |
| **412** | Precondition Failed    | One or more preconditions in the request headers (e.g., `If-Match`) failed. Commonly used with optimistic locking.    |
| **415** | Unsupported Media Type | The server does not support the request's media type (e.g., sending XML when only JSON is accepted).                  |
| **422** | Unprocessable Entity   | The request is syntactically correct but contains semantic or business validation errors. Commonly used in REST APIs. |
| **429** | Too Many Requests      | The client has exceeded the allowed rate limit. Retry after some time.                                                |


## Server Errors

| Code    | Meaning               | Description                                                                    |
| ------- | --------------------- | ------------------------------------------------------------------------------ |
| **500** | Internal Server Error | An unexpected error occurred on the server.                                    |
| **501** | Not Implemented       | The server does not support the requested functionality or HTTP method.        |
| **502** | Bad Gateway           | A gateway or proxy received an invalid response from an upstream server.       |
| **503** | Service Unavailable   | The server is temporarily unavailable due to maintenance or overload.          |
| **504** | Gateway Timeout       | A gateway or proxy did not receive a timely response from the upstream server. |


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

ETag, or Entity Tag, is an HTTP response header that uniquely identifies the current version of a resource. It is primarily used for HTTP caching and optimistic locking. For caching, the client sends the ETag back in the If-None-Match header, allowing the server to return 304 Not Modified if the resource hasn't changed. For updates, the client uses the If-Match header, and if the resource version has changed, the server returns 412 Precondition Failed to prevent overwriting another user's changes.

Used for:

- HTTP Caching
- Optimistic Locking

---

# 21. What is Optimistic Locking in REST?

Optimistic Locking is a concurrency control mechanism used to prevent lost updates when multiple clients try to update the same resource simultaneously.

Unlike pessimistic locking, it does not lock the resource. Instead, it checks whether the resource has been modified by someone else before applying the update.

In REST APIs, optimistic locking is typically implemented using ETag and the If-Match header.

The client sends the current version.

```http
If-Match: "v3"
```

If the resource has changed:

```http
412 Precondition Failed
```

Prevents lost updates.

Advantages
Prevents lost updates
No database locking
Better performance than pessimistic locking
Suitable for REST APIs and microservices
Works well when conflicts are rare

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

Pagination is a technique used to divide a large dataset into smaller, manageable pages instead of returning all records in a single API response.

---

**Why is Pagination Needed?**

Imagine a database with 10 million users.

Without pagination:

```http
GET /users
```

The server returns all 10 million records.

Problem:
- Slow response
- High memory consumption
- Heavy network traffic
- Poor user experience
- Increased database load

# With Pagination

Instead, request only a subset of records.

```http
GET /users?page=0&size=20
```
---

Types of Pagination
1. Offset-Based Pagination (Most Common)

Uses **page number** and **page size**.

### Example

```http
GET /users?page=2&size=10
```

Meaning:

- Page = 2
- Size = 10

### SQL Query

```sql
SELECT *
FROM users
LIMIT 10 OFFSET 20;
```

2. Cursor-Based Pagination (Recommended for Large Data)

Instead of page numbers, use a **cursor** (usually the last seen record ID or timestamp).

### Example

```http
GET /users?cursor=101&limit=20
```

### SQL Query

```sql
SELECT *
FROM users
WHERE id > 101
LIMIT 20;
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

| Feature | Offset Pagination | Cursor Pagination |
|----------|-------------------|-------------------|
| Uses | Page Number | Cursor/Last Record |
| Performance | Slower for large datasets | Very Fast |
| Jump to Any Page | ✅ Yes | ❌ No |
| Best For | Admin dashboards | Social media feeds, APIs with large datasets |

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

# 26. What is CORS?
**CORS (Cross-Origin Resource Sharing)** is a browser security mechanism that allows or restricts a web page from making requests to a different origin (domain, protocol, or port).

Without CORS, browsers enforce the **Same-Origin Policy (SOP)**, which blocks requests to different origins.

# How CORS Works

## Step 1

Browser sends the request.

```http
GET /users
Origin: https://myapp.com
```

Notice the **Origin** header.

---

## Step 2

Server checks whether this origin is allowed.

If allowed:

```http
Access-Control-Allow-Origin: https://myapp.com
```

Browser allows the response.

If not allowed:

No CORS header is returned.

Browser blocks access to the response.


---
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
