import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import panzoom from 'panzoom';

@Component({
  selector: 'app-map-dialog',
  templateUrl: './map-dialog.component.html',
  styleUrls: ['./map-dialog.component.scss']
})
export class MapDialogComponent implements AfterViewInit {

  constructor(public dialogRef: MatDialogRef<MapDialogComponent>) { }
  @ViewChild('mapImage') mapImage: ElementRef;

  ngAfterViewInit() {
    panzoom(this.mapImage.nativeElement, {
      maxZoom: 100,  // Maximum zoom level, adjust as needed
      minZoom: 0.5  // Minimum zoom level, adjust as needed
    });
  }
  showInfo(pin: string): void {
    // Fetch the information from the backend
    // this.yourService.getPinInfo(pin).subscribe(info => {
    //   // Show the information
    //   ;
    // });

  }
  showInfo3(pin: string): void {

  }
  showInfo2(pin: string): void {
    // Fetch the information from the backend
    // this.yourService.getPinInfo(pin).subscribe(info => {
    //   // Show the information
    //   ;
    // });

  }
  closeDialog(): void {
    this.dialogRef.close();
  }
}
