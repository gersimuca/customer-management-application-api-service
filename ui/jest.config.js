module.exports = {
  preset: 'jest-preset-angular',
  snapshotSerializers: [
    'jest-preset-angular/build/serializers/no-ng-attributes',
    'jest-preset-angular/build/serializers/ng-snapshot',
    'jest-preset-angular/build/serializers/html-comment',
  ],
  moduleNameMapper: {
    '^@shared/(.*)$': '<rootDir>/src/app/shared/$1',
    '^@api': '<rootDir>/src/data-access',
    '^@env/(.*)$': '<rootDir>/src/environments/$1',
    '^@state/(.*)$': '<rootDir>/src/app/+state/$1',
    '^@state': '<rootDir>/src/app/+state',
  },
  setupFilesAfterEnv: ['<rootDir>/setup-jest.ts', '<rootDir>/src/polyfills.ts'],
  testPathIgnorePatterns: ['e2e'],
  collectCoverage: true,
  collectCoverageFrom: ['src/app/**/*.ts', '!src/app/**/*.module.ts', '!src/app/**/*.const.ts', '!src/app/**/*.model.ts', '!src/app/**/*.enum.ts', '!src/app/**/index.ts'],
  reporters: [
    'default',
    [
      '@mediainstinctgroup/jest-sonar-reporter',
      {
        reportPath: 'reports',
        reportFile: 'erp-ui-service-report.xml',
      },
    ],
  ],
};

