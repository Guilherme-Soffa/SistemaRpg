import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClasseDTO } from 'src/modules/classe-dto';
import { RacaDTO } from 'src/modules/raca-dto';
import { FichaService } from '../service/ficha.service';

interface item {
  value: string;
  label: string;
}

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.scss']
})
export class FichaComponent implements OnInit {

  raca: RacaDTO[] = [];
  classe: ClasseDTO[] = [];

  origem: item[] =[
    {value: '1', label: 'huaaaaaaaaaaaaaaaaamano B'},
    {value: '2', label: 'eqwe lua'},
    {value: '3', label: 'dd'},
  ]

  antecedente: item[] =[
    {value: '1', label: 'das B'},
    {value: '2', label: 'das lua'},
    {value: '3', label: 'ddd'},
  ]

  form: FormGroup;
  selected = 'option2';

  constructor(
    readonly formBuilder: FormBuilder,
    private fichaService: FichaService,//(raca classe)
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      raca: [null, Validators.required],
      classe: [null, Validators.required],
      antecedente: [null, Validators.required],
      origem: [null, Validators.required],
    })
    this.fichaService.buscarRacaClasse().subscribe(r=>{
    })
  }

  submit(){
    console.log('teste',this.trataDados())
  }




  trataDados(){
    const dados =  this.form.controls;





  }
}
