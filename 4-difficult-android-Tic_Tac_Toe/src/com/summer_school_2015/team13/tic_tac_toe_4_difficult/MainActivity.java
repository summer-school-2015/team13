package com.summer_school_2015.team13.tic_tac_toe_4_difficult;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.*;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity implements View.OnTouchListener {
    int cellsInLine;
    int cellsInRaw;

    int deviceWidth;
    int deviceHeight;

    int cellsWidth;
    int cellsHeight;

    int lineWidth;

    int colorCircle;
    int colorCross;

    boolean turnCircles;

    ImageView imageView1;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;

    Cell[][] cells;

    private void showWrongTurnDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.message_wrong_turn);
        builder.setNeutralButton(R.string.message_button_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });

       AlertDialog dialogWrongTurn = builder.create();
        dialogWrongTurn.show();
    }

    private int getFactor(int coordinate) {  //For move figure if near the side
        switch (coordinate) {
            case 1:
                return -1;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    private void drawCircle(Point point) {
        paint.setColor(colorCircle);
        paint.setStyle(Paint.Style.STROKE);


        float x = (point.x - 1) * cellsWidth + cellsWidth / 2 + lineWidth / 4 * getFactor(point.x);
        float y = (point.y - 1) * cellsHeight + cellsHeight / 2 + lineWidth / 4 * getFactor(point.y);

        float radius = Math.min(cellsHeight, cellsWidth) / 2 - 2 * lineWidth;

        canvas.drawCircle(x, y, radius, paint);

        imageView1.invalidate();
    }

    private void drawCross(Point point) {
        paint.setColor(colorCross);
        paint.setStyle(Paint.Style.STROKE);

        float center_x = (point.x - 1) * cellsWidth + cellsWidth / 2 + lineWidth / 4 * getFactor(point.x);
        float center_y = (point.y - 1) * cellsHeight + cellsHeight / 2 + lineWidth / 4 * getFactor(point.y);

        float indent = Math.min(cellsHeight, cellsWidth) / 2 - 2 * lineWidth;

        canvas.drawLine(center_x - indent, center_y - indent, center_x + indent, center_y + indent, paint);
        canvas.drawLine(center_x + indent, center_y - indent, center_x - indent, center_y + indent, paint);

        imageView1.invalidate();
    }

    private void makeTurn(Point point) {
        if (cells[point.x][point.y] == Cell.EMPTY) {
            if (turnCircles) {
                drawCircle(point);
                cells[point.x][point.y] = Cell.CIRCLE;
            } else {
                drawCross(point);
                cells[point.x][point.y] = Cell.CROSS;
            }

            turnCircles = !turnCircles;
        } else {
            showWrongTurnDialog();
        }
    }

    private void drawMap() {
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);

        lineWidth = Math.min(deviceHeight, deviceWidth) / 100;
        paint.setStrokeWidth(lineWidth);

        cellsHeight = deviceHeight / cellsInRaw;
        cellsWidth = deviceWidth / cellsInLine;

        for (int i = 1; i < cellsInRaw; i++) {
            canvas.drawLine(0, i * cellsHeight, deviceWidth, i * cellsHeight, paint); //draw horizontal lines
        }
        for (int i = 1; i < cellsInRaw; i++) {
            canvas.drawLine(i * cellsWidth, 0, i * cellsWidth, deviceHeight, paint); //draw vertical lines
        }

        imageView1.invalidate();
    }

    private void initialiseCells() {
        cells = new Cell[cellsInLine + 1][cellsInRaw + 1];

        for (int i = 1; i <= cellsInLine; i++) {
            for (int j = 1; j <= cellsInRaw; j++) {
                cells[i][j] = Cell.EMPTY;
            }
        }
    }

    Point dCoordinatesTogCoordinates(float x, float y) {
        Point point = new Point();
        point.x = (int) x / cellsWidth + 1;
        point.y = (int) y / cellsHeight + 1;

        return point;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Fullscreen code starts
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);
        //Fullscreen code ends

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnTouchListener(this);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        deviceWidth = size.x;
        deviceHeight = size.y;

        bitmap = Bitmap.createBitmap(deviceWidth, deviceHeight, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView1.setImageBitmap(bitmap);

        paint = new Paint();


        Random random = new Random();
        if (random.nextBoolean()) {
            colorCircle = Color.BLUE;
            colorCross = Color.RED;
        } else {
            colorCircle = Color.RED;
            colorCross = Color.BLUE;
        }
        turnCircles = random.nextBoolean();

        cellsInLine = 4;
        cellsInRaw = 4;

        initialiseCells();
        drawMap();

        //dialogWrongTurn = new DialogWrongTurn();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v instanceof ImageView) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Point point = dCoordinatesTogCoordinates(event.getX(), event.getY());
                makeTurn(point);
            }
            return true; //Means we consumed event
        }
        return false; //Means we didn't consme event
    }
}
