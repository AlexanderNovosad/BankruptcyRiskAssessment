import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bancruptcy-analysis',
  templateUrl: './bancruptcy-analysis.component.html',
  styleUrls: ['./bancruptcy-analysis.component.css']
})
export class BancruptcyAnalysisComponent implements OnInit {

  constructor() { }
  modelSelectionOpen: boolean = true;

  ngOnInit() {
    this.modelSelectionOpen = true;
  }

  public closeModelSelectionWindow(){
    this.modelSelectionOpen = false;
  }

}
