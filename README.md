# ERP Api Service App

## Getting Started

To start your own new application clone this repository.

### Authorization

> On Authentication and Authorisation is done by OpenID Connect. For using the RedHat SSO with OpenID
> Connect for a new client/project, an onboarding is necessary. Developer or Application Owner.

Authorization is done using the OpenID connect support of *Spring* security and the LHT *Keycloak*.
The `erp-api-service` uses a configured `engdci` client that has multiple users:

- admin
- readonly
- user

Check out the `requests.http` file where you can authenticate as one of the two and fire up requests against the API.

### Health Services

This application uses *Spring Boot Actuator* to provide basic health checks.

| ***Route***                    | ***Description***                           |
|--------------------------------|---------------------------------------------|
| ```/status/health/liveness```  | The application is up and running.          |
| ```/status/health/readiness``` | The application is ready to serve requests. |

### Databases

We use *Flyway* for the database migrations. For database changes, please create a new migration file
with a version, it will be applied at the next app start.

To run a *SQL Sever* instance locally just run ```$ docker-compose -f docker/docker-compose.yml up -d```.
This database is getting pre-filled at application start up.

### OpenAPI Documentation

*OpenAPI* documentation is generated via [springdoc](https://github.com/springdoc/springdoc-openapi).
The JSON specification is available

## Configuration

The application should be configured via environment variables.
Environment variables will overwrite certain stage/deployment specific properties in the `application.yaml`.
In OpenShift the environment variables are provided via the `DeploymentConfig`.

| Variable               | Effect                                                                                | Value for local dev                                                                                                                                                                         |
|------------------------|---------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `DB_JDBC_URL`          | JDBC connection string.                                                               | `jdbc:sqlserver://localhost:1433;database=engdci_db;encrypt=false;trustServerCertificate=false;`                                                                                            |
| `DB_USERNAME`          | Database username.                                                                    | `erp_db_user`                                                                                                                                                                            |
| `DB_PASSWORD`          | Database password.                                                                    | `secretL0calPassword`                                                                                                                                                                       |
| `DB_JDBC_DRIVER`       | The JDBC driver, such as \*com.microsoft.sqlserver.jdbc.SQLServerDriver\* (Azure DB). | `com.microsoft.sqlserver.jdbc.SQLServerDriver`                                                                                                                                              |
| `SSO_CLIENT_ID`        | The SSO client.                                                                       | `erp`                                                                                                                                                                                    |
| `SSO_JWK_SET_URI`      | URL to the SSO certificate endpoint.                                                  | `http://localhost:8180/auth/realms/ERP/protocol/openid-connect/certs`                                                                                                                       |
| `CORS_ALLOWED_ORIGINS` | Comma separated allowed CORS origin URLs.                                             | `http://localhost:4200`                                                                                                                                                                     |
| `LOG_LEVEL`            | Sets the \*Spring\* root log level.                                                   |                                                                                                                                                 

## Development

### Starting local infrastructure

It is recommended to develop against the local *SQL Server* instance. To make it available, execute the following
command:

- `docker compose -f docker/docker-compose.yml up -d` (macOS and Linux)
- `docker compose -f docker\docker-compose.yml up -d` (Windows)

### Starting the service

#### IntelliJ (for development only)

If you are using IntelliJ, you should create run configurations and make sure to configure the
appropriate [environment variables](#Configuration) to each configuration.
