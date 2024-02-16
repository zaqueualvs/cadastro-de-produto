import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import {provideRouter} from '@angular/router';

import {APP_ROUTES} from './app.routes';
import {provideClientHydration} from '@angular/platform-browser';
import {HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(APP_ROUTES), provideClientHydration(), importProvidersFrom(HttpClientModule), provideHttpClient(withFetch())]
};
