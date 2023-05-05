import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  register: FormGroup;
  constructor() { }

  ngOnInit(): void {
    this.createForm();
    this.register.valueChanges.subscribe(data => console.log(data));
  }
  createForm() {
    this.register = new FormGroup({
      email: new FormControl('', [Validators.minLength(6), Validators.required, Validators.pattern('^[a-z]+([\\_\\.]?[a-z\\d]+)*@[a-z]{3,7}\\.[a-z]{3}$')]),
      passwordGroup: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl()
      }, {validators: this.comparePassword}),
      country: new FormControl('', Validators.required),
      age: new FormControl('', {validators: this.checkAgeOver18}),
      gender: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$'), Validators.required])
    });
  }

  comparePassword(elementControl: AbstractControl) {
    const elementPassword = elementControl.value;
    return (elementPassword.password === elementPassword.confirmPassword) ? null : {notmatch: true};
  }

  checkAgeOver18(elementControl: AbstractControl) {
    const dateOfBirth = elementControl.value;
    const year = Number(dateOfBirth.substr(0, 4));
    const currentYear = new Date().getFullYear();
    return currentYear - year >= 18 ? null : {invalid: true};
  }

  onSubmit() {
  }
}
