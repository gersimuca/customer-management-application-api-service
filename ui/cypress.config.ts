import { defineConfig } from 'cypress';

export default defineConfig({
  video: false,
  recoverFromRendererCrashes: true,
  defaultCommandTimeout: 10000,
  pageLoadTimeout: 120000,
  requestTimeout: 20000,
  responseTimeout: 120000,

  e2e: {
    baseUrl: 'http://localhost:4200',
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});

