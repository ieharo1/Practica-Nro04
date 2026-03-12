import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'dashboard', loadComponent: () => import('./pages/dashboard.page').then(m => m.DashboardPage) },
  { path: 'login', loadComponent: () => import('./pages/login.page').then(m => m.LoginPage) },
  { path: 'producto', loadComponent: () => import('./pages/producto.page').then(m => m.ProductoPage) },
  { path: 'categoria', loadComponent: () => import('./pages/categoria.page').then(m => m.CategoriaPage) },
  { path: 'cliente', loadComponent: () => import('./pages/cliente.page').then(m => m.ClientePage) },
  { path: 'pedido', loadComponent: () => import('./pages/pedido.page').then(m => m.PedidoPage) },
  { path: 'pedido_detalle', loadComponent: () => import('./pages/pedido_detalle.page').then(m => m.PedidoDetallePage) },
  { path: 'pago', loadComponent: () => import('./pages/pago.page').then(m => m.PagoPage) },
  { path: 'usuario', loadComponent: () => import('./pages/usuario.page').then(m => m.UsuarioPage) },
  { path: '**', redirectTo: 'dashboard' }
];
