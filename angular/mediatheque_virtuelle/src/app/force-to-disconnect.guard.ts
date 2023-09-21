import { CanActivateFn } from '@angular/router';
import { AuthService } from './auth.service';
import { inject } from '@angular/core';

export const forceToDisconnectGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  
  if((state.url == "/connection" || state.url == "/signin") && authService.isAuthenticated()) {
    authService.disconnection()
    return true;
  }
  
  return true;
};
