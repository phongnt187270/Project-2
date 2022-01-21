<?php

/** @var \Illuminate\Database\Eloquent\Factory $factory */

use App\User;
use Faker\Generator as Faker;

$factory->define(User::class, function (Faker $faker) {
    return [
        //
        'user_id' => $faker->sentence(8),
        'phonenumber' => $faker->phoneNumber,
        'password' => $faker->sentence(8),
        'name' => $faker->firstname,
        'dob' => $faker->date("Y-m-d"),
        'division' => $faker->sentence(6),
        'role'=> $faker->sentence(8),
        'vaccination_info_id ' => $faker->sentence(8)
    ];
});
