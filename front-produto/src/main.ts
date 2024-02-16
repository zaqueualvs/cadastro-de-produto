import {bootstrapApplication, BrowserModule} from '@angular/platform-browser';
import {appConfig} from './app/app.config';
import {AppComponent} from './app/app.component';
import {provideAnimations} from '@angular/platform-browser/animations';
import {PreloadAllModules, provideRouter, withPreloading} from "@angular/router";
import {importProvidersFrom} from "@angular/core";
import {MatToolbarModule} from "@angular/material/toolbar";
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {APP_ROUTES} from './app/app.routes';

bootstrapApplication(AppComponent,
  {
    providers: [importProvidersFrom(BrowserModule, MatToolbarModule),
      provideAnimations(),
      provideHttpClient(withInterceptorsFromDi()),
      provideRouter(APP_ROUTES, withPreloading(PreloadAllModules))]
  })

  .catch((err) => console.error(err));
