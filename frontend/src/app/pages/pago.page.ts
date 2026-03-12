import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
    import { MatTableModule } from '@angular/material/table';
    import { MatCardModule } from '@angular/material/card';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    import { MatButtonModule } from '@angular/material/button';
    import { MatCheckboxModule } from '@angular/material/checkbox';
    import { PagoService } from '../services/pago.service';

    @Component({
      selector: 'app-pago-page',
      standalone: true,
      imports: [CommonModule, ReactiveFormsModule, MatTableModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCheckboxModule],
      template: `
        <mat-card class="page-card">
          <h2>Pago</h2>
          <form [formGroup]="form" (ngSubmit)="save()" class="form-grid">
            <mat-form-field appearance=\"outline\"><mat-label>usuarioId</mat-label><input matInput type=\"number\" formControlName=\"usuarioId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>referenciaId</mat-label><input matInput type=\"number\" formControlName=\"referenciaId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>monto</mat-label><input matInput type=\"number\" formControlName=\"monto\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>metodo</mat-label><input matInput type=\"text\" formControlName=\"metodo\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>fecha</mat-label><input matInput type=\"datetime-local\" formControlName=\"fecha\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>estado</mat-label><input matInput type=\"text\" formControlName=\"estado\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>referencia</mat-label><input matInput type=\"text\" formControlName=\"referencia\" /></mat-form-field>
            <button mat-raised-button color="primary">Guardar</button>
          </form>
          <table mat-table [dataSource]="items" class="mat-elevation-z1">
          <ng-container matColumnDef="id">
  <th mat-header-cell *matHeaderCellDef>id</th>
  <td mat-cell *matCellDef="let row">{{row.id}}</td>
</ng-container>
          <ng-container matColumnDef="usuarioId">
  <th mat-header-cell *matHeaderCellDef>usuarioId</th>
  <td mat-cell *matCellDef="let row">{{row.usuarioId}}</td>
</ng-container>
          <ng-container matColumnDef="referenciaId">
  <th mat-header-cell *matHeaderCellDef>referenciaId</th>
  <td mat-cell *matCellDef="let row">{{row.referenciaId}}</td>
</ng-container>
          <ng-container matColumnDef="monto">
  <th mat-header-cell *matHeaderCellDef>monto</th>
  <td mat-cell *matCellDef="let row">{{row.monto}}</td>
</ng-container>
          <ng-container matColumnDef="metodo">
  <th mat-header-cell *matHeaderCellDef>metodo</th>
  <td mat-cell *matCellDef="let row">{{row.metodo}}</td>
</ng-container>
          <ng-container matColumnDef="fecha">
  <th mat-header-cell *matHeaderCellDef>fecha</th>
  <td mat-cell *matCellDef="let row">{{row.fecha}}</td>
</ng-container>
          <ng-container matColumnDef="estado">
  <th mat-header-cell *matHeaderCellDef>estado</th>
  <td mat-cell *matCellDef="let row">{{row.estado}}</td>
</ng-container>
          <ng-container matColumnDef="referencia">
  <th mat-header-cell *matHeaderCellDef>referencia</th>
  <td mat-cell *matCellDef="let row">{{row.referencia}}</td>
</ng-container>
          <ng-container matColumnDef="acciones">
  <th mat-header-cell *matHeaderCellDef>Acciones</th>
  <td mat-cell *matCellDef="let row">
    <button mat-button color="primary" (click)="edit(row)">Editar</button>
    <button mat-button color="warn" (click)="remove(row.id)">Eliminar</button>
  </td>
</ng-container>
            <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
            <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
          </table>
        </mat-card>
      `,
      styles: [`.page-card { padding: 20px; display: grid; gap: 16px; }`, `.form-grid { display: grid; gap: 12px; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); }`, `table { width: 100%; }`]
    })
    export class PagoPage {
      items: any[] = [];
      displayedColumns = ['id', 'usuarioId', 'referenciaId', 'monto', 'metodo', 'fecha', 'estado', 'referencia', 'acciones'];
      selectedId: number | null = null;
      form = this.fb.group({
        usuarioId: ['']
        referenciaId: ['']
        monto: ['']
        metodo: ['']
        fecha: ['']
        estado: ['']
        referencia: ['']
      });

      constructor(private fb: FormBuilder, private service: PagoService) {
        this.load();
      }

      load() {
        this.service.findAll().subscribe(data => (this.items = data));
      }

      edit(row: any) {
        this.selectedId = row.id;
        this.form.patchValue(row);
      }

      save() {
        const payload = this.form.value;
        if (this.selectedId) {
          this.service.update(this.selectedId, payload).subscribe(() => { this.selectedId = null; this.form.reset(); this.load(); });
        } else {
          this.service.create(payload).subscribe(() => { this.form.reset(); this.load(); });
        }
      }

      remove(id: number) {
        this.service.delete(id).subscribe(() => this.load());
      }
    }
