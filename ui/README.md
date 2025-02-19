# RP UI Service

## Getting Started

### Development

1) Install _Node.js_, [npm](https://docs.npmjs.com/cli/install) and the [Angular CLI](https://angular.io/cli).

2) Install dependencies via `npm install`

3) Generate code via ``npm run generate-data-access``.

Afterwards you can run/test your application as usual:
- `npm run test`
- `npm run e2e`
- `npm run start`

To run eslint run `npm run lint`.

## Build and Deployment Process

### Build (CI)

The application is built on the *Jenkins* via Jenkinsfile.
It has quality gates for the correct formatting and tests.
It also deploys the results to [SonarQube]
and security reports to [Snyk.io]

### Deployment (CD)

I configure deployment via *Helm* charts.
Please check the `config/helm` folder in the source files.
Have a look at the `[OpenShift] Deployment` stage in the [`Jenkinsfile.groovy`](Jenkinsfile.groovy) for further information. |
