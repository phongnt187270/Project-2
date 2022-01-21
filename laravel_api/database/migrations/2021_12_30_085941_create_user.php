<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUser extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('user', function (Blueprint $table) {
            $table->string('user_id');
            $table->string('phonenumber');
            $table->string('password');
            $table->string('name');
            $table->date('dob');
            $table->string('division');
            $table->string('role');
            $table->string('vaccination_info_id')->nullable();
            $table->primary('user_id');
            $table->foreign('vaccination_info_id')
            ->references('vaccination_info_id')->on('vaccination_info');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('user');
    }
}
